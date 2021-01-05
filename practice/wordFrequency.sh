
#192. word frequency
#write a bash script to calculate the frequency of each word in a text file words.txt
#the day is sunny the the
#the sunny is is 
#the 4
#is 3
#sunny 2
#day 1
#write it in one-line using unix pipes

#!/bin/bash

FILENAME=$1
while read line
do
cut -d '"' -f2
echo $line
done < $FILENAME

$ cat file

"1" test
"2" test
"3" test
"4" test
"5" test