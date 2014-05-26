#see: http://stackoverflow.com/questions/8082277/tkinter-return-event-on-key-release

#use 'echo' sketch on arduino

# Xwindow libs
import Xlib.display as display
import Xlib.X as X

#Tkinter (GUI) lib
import Tkinter as tk

import atexit

#Serial protocol lib
import serial

#create serial object for serial comunication over port 'ttyACM0' at 9600 bauds
try:
    ser = serial.Serial("/dev/ttyACM0", 9600)
except:
    ser = serial.Serial("/dev/ttyACM1", 9600)
else:
    print "ERROR: Arduino not found"

last_dir = ''
last_mot = ''

#cleanup at exit
@atexit.register

#disable key autorepeat in X windows for easier tracking of keystates
def autorepeat():
    d=display.Display()    
    d.change_keyboard_control(auto_repeat_mode=X.AutoRepeatModeOn)
    x=d.get_keyboard_control()    

#GUI using Tkinter. Used to identify key presses and releases
class App(object):
    
    #key states are saved in variables as flags
    right_state = False
    left_state = False
    up_state = False
    down_state = False

    def __init__(self, master, **kwargs):
        
        self.master=master

        #bind events to functions
        master.bind('<KeyRelease>',self.release)
        master.bind('<KeyPress>', self.press)

    #called when key is pressed
    def press(self, event):

        if event.keysym == 'Right': 
            App.right_state = True

        elif event.keysym == 'Left':
            App.left_state = True

        elif event.keysym == 'Up':
            App.up_state = True

        elif event.keysym == 'Down':
            App.down_state = True

    #called when key is released
    def release(self, event):
         
         if event.keysym == 'Right':
             App.right_state = False

         elif event.keysym == 'Left':
             App.left_state = False

         elif event.keysym == 'Up':
             App.up_state = False

         elif event.keysym == 'Down':
            App.down_state = False

         elif event.keysym == 'Escape':
             root.destroy()

         
#set auto repeat mode to off
d=display.Display()
d.change_keyboard_control(auto_repeat_mode=X.AutoRepeatModeOff)
x=d.get_keyboard_control()

#create Tkinter object 'root' for GUI
root=tk.Tk()
app=App(root)

#Updates the console with the final, interpreted command
def update():
    
    global last_dir 
    global last_mot 

    dir_command = ''
    mot_command = ''

    if App.left_state == True and App.right_state == False:
       dir_command = 'l'

    elif App.right_state == True and App.left_state == False:
        dir_command = 'r'

    elif App.right_state == True and App.left_state == True:
        dir_command = 'c'

    else:
        dir_command = 'c'


    if App.up_state == True and App.down_state == False:
       mot_command = 'f'

    elif App.down_state == True and App.up_state == False:
        mot_command = 'b'

    elif App.up_state == True and App.down_state == True:
        mot_command = 's'

    else:
        mot_command = 's'

    if dir_command != last_dir:
        last_dir = dir_command
        print 'update: '+ dir_command
        ser.write(dir_command)

    if mot_command != last_mot:
        last_mot = mot_command
        print ('update: '+ mot_command)
        ser.write(mot_command)

    #the 'update function is put back in root's queue every second.
    root.after(0, update)

root.after(100, update)

root.mainloop()
