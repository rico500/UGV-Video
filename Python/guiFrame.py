from Tkinter import *

class App:

    def __init__(self, master):

        frame = Frame(master)
        frame.pack()

        self.exit = Button(frame, text="QUIT", fg="red", command=frame.quit)
        self.exit.pack(side=LEFT)

        self.led = Button(frame, text="on/off", command=self.switch)
        self.led.pack(side=LEFT)

    def switch(self):
        print "The switch has been pressed"

root = Tk()

app = App(root)

root.mainloop()
