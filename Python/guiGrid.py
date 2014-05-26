from Tkinter import *

class App:

    def __init__(self, master):


        self.master = master


        self.exit = Button(master, text= "QUIT", fg="red", command=master.quit)
        self.exit.grid(column= 0, row= 1, sticky= W)


        self.hello_world = Button(master, text= "HELLO", 
                                  command= self.say_hello)
        self.hello_world.grid(column= 1, row= 1, sticky= W)
        

        self.reset = Button(master, text= "RESET", command= self.reset)
        self.reset.grid(column= 2, row= 1)


        self.message = Message(master, text= "1,2... 1,2... this is a test",
                               bg= "white", borderwidth= 5,
                               relief= GROOVE, width= 100) 
        self.message.grid(column= 0, row= 0, columnspan= 2)


        master.bind("<Escape>", self.escape)


    def say_hello(self):
        print "Hello world!"
        self.message.config(text= "Hello world!")    

    def escape(self, event):
        print "Quit: App"
        self.master.destroy()

    def reset(self):
        print "Reset"
        self.message.config(text= "")

root = Tk()
app = App(root)
root.mainloop()
