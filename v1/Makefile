#
# CAVE_DIR
#    Set this to the directory where your
#    cave code is located. Can be:
#       - relative (e.g. ../../cavegame)
#       - absolute (e.g. /home/hesa/edu/cavegame)
#
CAVE_DIR=../../../cavegame/remake-v1

#
# TEST_FILES - Java files with test (and main)
#
TEST_FILES= \
    se/juneday/cavetest/classes/ThingTest.java \
    se/juneday/cavetest/classes/RoomTest.java

#
# CLASSPATH
#
CLASSPATH= $(CAVE_DIR):.

#
# Rule to compile java files
#
%.class:%.java
	@echo Compiling $<
	@javac -cp $(CLASSPATH):. $<

#
# Don't fiddle with the below
#
TEST_CLASSES=$(TEST_FILES:%.java=%.class)

all: check

clean:
	@echo Cleaning up
	@-rm -f $(THING_CLASSES)

check: $(TEST_CLASSES)
	@echo
	@for class in $(TEST_CLASSES) ; do \
		echo "Executing $$class" ; echo "-------------------" ;\
		java -ea -cp $(CLASSPATH) `echo $$class | sed 's,\.class,,g'` || exit 1; \
		echo ; \
	done

stat:
	@echo -n "Number of test files: "
	@find . -name "*.java" | wc -l
	@echo -n "Number of asserts: "
	@find . -name "*.java" | xargs grep assert | wc -l
