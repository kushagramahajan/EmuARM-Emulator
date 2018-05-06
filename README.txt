ABOUT EMUARM

EmuArm is an ARM ISA emulator. It can be used to write, execute, and debug 
programs written in the ARM and Thumb assembly languages. It has a graphical
mode as well as a command line mode.

Features provided: 

-- In-built text editor to code and debug ARM code 
-- Emulation support for the ARM ISA
-- Thumb ISA 
-- Breakpoints to assist debugging the program 
-- Easy console input for integers 
-- Step Into, Step Over and Step Out functions to get detailed line-by-line execution
   information of the program


How to launch the GUI Version of EmuArm: 

-- enter the emuarm directory 
-- to compile the source code : type 'ant compile' on the terminal 
-- to make the jar files : type 'ant jar' on the terminal 
-- to run the jar (emuArm.jar) that is created using GUI, simply type java -jar emuArm.jar 


How to launch the Command Line Version of EmuArm:

-- enter the emuarm directory
-- to compile the source code : type 'ant compile' on the terminal 
-- to make the jar files : type 'ant jar' on the terminal 
-- to run the jar (emuArm.jar) that is created, using an assembly file as input, simply type java -jar emuArm.jar -f=filename.
   We can either enter the absolute ore the relative path of the file. Eg. java -jar emuArm.jar -f=temp.s
-- to display the register, branch and memory tables in the output in command line mode, type -tables after
-f=<filename>

Usage: 
You can type regular ARM assembly code, and EmuArm will recognize it. If you need to write Thumb code
first put the directive .thumb on a separate line. EmuArm supports two more directives: .read and .print.
The .read directive is used to read the value of a register from the command line.
For example you can write:
.read r1
This statement will read in a value into the register r1 from the command line or the GUI console (similar to scanf in C). 

The .print directive can be used to print the value of a register to the command line or the GUI console.
For example: 
.print r1

See the file example.s in this directory.

Documentation
---------------

For detailed information and EmuARM documentation, please refer to 
http://www.cse.iitd.ac.in/~srsarangi/files/software/emuarm/emuarm-manual.pdf
