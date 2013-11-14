# Nate Mara
# Lab: Loop-controlled grade entry
# October 31, 2013
# Description: This lab gives practice
#   with using a loop to control data entry.
#   Inside the loop will be code to process
#   the data, item by item.
# DECLARE VARIABLES HERE
# BEFORE the loop ask the user for the first number.
# Use a while loop to process scores as long
# as the user enters scores that aren't negative.
# INSIDE the loop is where all the data processing
# will go.
# AFTER the loop, display the results.  This
# is where you should check to see whether to
# display "No data entered." or to display
# the average, min, max, etc.

allScores = ""
runningTotal = 0
displayScore = 2
numScores = 0

currentTestScore = float(raw_input("Enter test score #1 (negative quits): "))
currentMax = currentTestScore
currentMin = currentTestScore

while currentTestScore >= 0:
    allScores += str(currentTestScore) + " "
    runningTotal += currentTestScore

    currentMax = max(currentTestScore, currentMax)
    currentMin = min(currentTestScore, currentMin)

    currentTestScore = float(raw_input("Enter test score #" + str(displayScore) + 
        " (negative quits): "))

    numScores += 1
    displayScore += 1
    meanScore = runningTotal / numScores

if len(allScores) == 0:
    print
    print "No data entered."

else:
    print
    print "You entered " + str(numScores) + " test scores:"
    print str(allScores)
    print 
    print "The mean score is " + str(meanScore)
    print "The lowest score is " + str(currentMin)
    print "The highest score is " + str(currentMax)