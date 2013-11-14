"""
Nate Mara
2013-10-03

"Wing Load Calculator"

This program calculates the lbs/sq-ft 
load of a parachuter while falling

"""

jumper_weight = 0.0
rig_weight = 0.0
parachute_size = 0.0
wing_load = 0.0

def main():
    # calls all of the methods nesicarry for the program to run
    welcome_banner();
    prompt_user();
    calculate_load();
    print_wing_load();

def welcome_banner():
    print """--------------------------------------------------
--------------------------------------------------
||    Welcome to Nate's Wing Load Calculator    ||
||         Version 0.0.0.1 (alpha build)        ||
||                                              ||
||  This program can be used to calculate the   ||
||  pounds-per-square-foot load of a parachute. ||
||                                              ||
|| NOTICE: This software should not be used for ||
|| lifesaving advice, please consult a licensed ||
||  skydiving instructor before attempting any  ||
||    dangerous activities such as skydiving.   ||
||                                              ||
||   To get started, look at the prompt below.  ||
--------------------------------------------------
--------------------------------------------------
        
        """

def prompt_user():
    # Prompts user for jumper information

    global jumper_weight
    global rig_weight
    global parachute_size

    jumper_weight = float(raw_input("Please enter the weight of the jumper in pounds: "))
    print

    rig_weight = float(raw_input("Please enter the weight of the rig (parachute & container) in pounds: "))
    print

    parachute_size = float(raw_input("Please enter the size of the parachute in square feet: "))
    print

def calculate_load():
    # defines wingloading total
    global wing_load
    wing_load = (jumper_weight + rig_weight) / parachute_size

def print_wing_load():
    # prints the sentence containing all of the info for the user
    print "For a diver weighing " + str(jumper_weight) + " lbs, and a rig weighing " + str(rig_weight) + " lbs," + "\n" + "the wing-load is " + str(wing_load) + " lbs/sq-ft."
    print

if __name__ == '__main__': 
    main()
