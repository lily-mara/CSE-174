def main():
    print "There are " + str(count_K()) + " 'k's in the first 10,000 words."

    line_num = 12345
    print "The word on line " + str(line_num) + " is " + at_line(line_num) + "."

    print words_with_length(2)
    print words_with_length(3)
    print words_with_length(4)
    print words_that_end_with("Q")
    print a_not_b("Q", "U")
    print only_at_index("B", 3)

def count_K():
    words = open("words.txt", "r")
    kCount = 0

    for i in range(0, 10000):
        current_word = words.readline()
        if current_word.find("K") != -1:
            kCount += 1

    words.close()
    return kCount

def at_line(line_number):
    words = open("words.txt", "r")

    for i in range(0, line_number):
        current_word = words.readline()

    words.close()
    return current_word.rstrip()

def words_with_length(word_length):
    words = open("words.txt", "r")
    word_count = 0

    for i in words:
        if len(i.rstrip()) == word_length:
            word_count += 1

    words.close()
    return "There are {0} words with {1} letters.".format(word_count, word_length)

def words_that_end_with(test_char):
    words = open("words.txt", "r")
    count = 0

    for i in words:
        last_char = i.rstrip()[-1:]
        
        if last_char == test_char:
            count += 1

    words.close()
    return "There are {0} words ending with char '{1}'.".format(count, test_char)

def a_not_b(a, b):
    words = open("words.txt", "r")
    count = 0

    for i in words:
        has_a = i.find(a) != -1
        has_b = i.find(b) != -1

        if has_a and not has_b:
            count += 1 

    words.close()
    return "There are {0} words that contain char '{1}' but not char '{2}'.".format(count, a, b)

def only_at_index(test_char, test_index):
    words = open("words.txt", "r")
    count = 0
    has_at_test_index = False
    has_at_one = True
    has_at_zero = True

    for i in words:
        if len(i) - 1 > test_index:
            has_at_test_index = i[test_index] == test_char
            has_at_zero = i[0] == test_char

        if len(i) > 1:
            has_at_one = i[1] == test_char

        meets_conditions = has_at_test_index and not has_at_zero and not has_at_one 

        if meets_conditions:
            count += 1

    words.close()
    return "There are {0} words that have char '{1}' at index {2}, but not at 0 or 2.".format(count, test_char, test_index)

if __name__ == "__main__": main()
