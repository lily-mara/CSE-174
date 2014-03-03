"""
 * WordPlay
 * Nate Mara
 * 2013-11-06
 *
 * Follows a given set of criteria for checking different things
 * about user inputted strings.
 * 
"""
from random import randint

def main():
    # keeps prompting the user for a word until 'Q' is entered

    prompt = "Enter a word for me to analyze (or Q to quit): "
    print

    userInput = raw_input(prompt)

    while userInput != "Q":
        showStats(userInput)
        userInput = raw_input(prompt)

def showStats(word):
    # after the user enters a word, this shows all the info about it

    word = word.upper()
    print
    print "Results for " + word + ":"
    print "Number of vowels: " + str(vowelCount(word))
    if vowelCount(word) != 0 :
        firstVowel = word[indexOfFirstVowel(word)]
        firstVowelPos = indexOfFirstVowel(word)

        print "First vowel is: " + firstVowel + " in position " + str(firstVowelPos)
    
    print "Pig Latin: " + pigLatinize(word)
    print "Ends swapped: " + swapEnds(word)
    print "Reversed: " + reverse(word)
    print "Ends swapped and reversed: " + reverse(swapEnds(word))
    print "Scrambled: " + multiScramble(word)
    printAllSubstrings(word);

def vowelCount(word):
    # returns number of vowels in word using iteration
    numVowels = 0

    for i in word:
        if vowelCheck(i):
            numVowels += 1
    return numVowels

def indexOfFirstVowel(word): 
    # returns index of first vowel in word using iteration
    for i in range(0, len(word)):
        currentChar = word[i]
        
        if vowelCheck(currentChar):
            return i
    return -1

def pigLatinize(word):
    # returns word translated to 'pig latin'

    if indexOfFirstVowel(word) == -1:
        return word + "AY"

    elif indexOfFirstVowel(word) == 0:
        return word + "HAY"

    else:
        untilVowel = word[:indexOfFirstVowel(word)]
        vowelToEnd = word[indexOfFirstVowel(word):]
        return vowelToEnd + untilVowel + "AY"
    
def swapEnds(word):
    # returns the word with the first and last chars switched
    firstChar = word[0]
    lastChar = word[len(word) - 1]

    if len(word) == 1:
        return word

    middle = word[1:len(word) - 1]

    return lastChar + middle + firstChar

def reverse(word): 
    # returns the reverse of the word
    reversedString = ""

    for i in range(0, len(word)):
        index = len(word) - i
        reversedString += word[index - 1]

    return reversedString

def scramble(word): 
    # returns scrambled version of word
    scrambleString = ""
    lenWord = len(word)

    for i in range(0, lenWord):
        myRandInt = randint(0, len(word) - 1)
        randChar = word[myRandInt]
        scrambleString += randChar
        word = word[:myRandInt] + word[myRandInt + 1:]  

    return scrambleString

def vowelCheck(testChar): 
    # returns True if char is vowel, returns False otherwise
    isA = testChar == 'A'
    isE = testChar == 'E'
    isI = testChar == 'I'
    isO = testChar == 'O'
    isU = testChar == 'U'

    if isA | isE | isI | isO | isU:
        return True

    return False

def multiScramble(word): 
    # returns 5 scrambled versions of 'word' each separated by single space
    stringSum = ""
    for i in range(0, 5):
        stringSum += scramble(word) + " "

    return stringSum

def printAllSubstrings(word): 
    # prints all substrings of 'word' with asterisk borders on each side
    # and on top/bottom
    lenWord = len(word)
    count = 0

    print "All substrings of " + word + ":"
    print nStars(lenWord)

    for length in range(1, lenWord + 1):
        for start in range(0, lenWord - length + 1):
            printSubstring(word[start:start + length], lenWord)
            count += 1

    print nStars(lenWord)
    print str(count) + " substrings found."

def nStars(n): 
    # returns the top or bottom border for a word 'n' characters long
    n += 4 
    return "*" * n

def printSubstring(substring, totalLength): 
    # prints a substring with star and space on either side. totalLength refers
    # to the total length of the original word.
    difference = totalLength - len(substring)
    endingSpace = " " * difference

    print "* " + substring + endingSpace + " *"

if __name__ == '__main__':main()
