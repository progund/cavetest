#
# CAVE_DIR
#    Set this to the directory where your
#    cave code is located. Can be:
#       - relative (e.g. ../../cavegame)
#       - absolute (e.g. /home/hesa/edu/cavegame)
#
CAVE_DIR=../../cavegame/remake-v1

#
# THING_FILES - files testing the Thing class
#
THING_FILES= \
    se/juneday/cavetest/thing/ThingTest.java

#
# CLASSPATH
#
CLASSPATH= $(CAVE_DIR):.

#
# Rule to compile java files
#
%.class:%.java
	javac -cp $(CLASSPATH):. $<

#
# Don't fiddle with the below
#
THING_CLASSES=$(THING_FILES:%.java=%.class)

thing: $(THING_CLASSES)
	java -ea -cp $(CLASSPATH) se.juneday.cavetest.thing.ThingTest

