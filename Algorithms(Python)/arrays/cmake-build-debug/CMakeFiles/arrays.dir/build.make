# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.19

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /cygdrive/c/Users/atremblay/AppData/Local/JetBrains/CLion2021.1/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/atremblay/AppData/Local/JetBrains/CLion2021.1/cygwin_cmake/bin/cmake.exe -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/arrays.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/arrays.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/arrays.dir/flags.make

CMakeFiles/arrays.dir/meme.o: CMakeFiles/arrays.dir/flags.make
CMakeFiles/arrays.dir/meme.o: ../meme.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/arrays.dir/meme.o"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/arrays.dir/meme.o -c /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/meme.cpp

CMakeFiles/arrays.dir/meme.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/arrays.dir/meme.i"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/meme.cpp > CMakeFiles/arrays.dir/meme.i

CMakeFiles/arrays.dir/meme.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/arrays.dir/meme.s"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/meme.cpp -o CMakeFiles/arrays.dir/meme.s

# Object files for target arrays
arrays_OBJECTS = \
"CMakeFiles/arrays.dir/meme.o"

# External object files for target arrays
arrays_EXTERNAL_OBJECTS =

arrays.exe: CMakeFiles/arrays.dir/meme.o
arrays.exe: CMakeFiles/arrays.dir/build.make
arrays.exe: CMakeFiles/arrays.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable arrays.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/arrays.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/arrays.dir/build: arrays.exe

.PHONY : CMakeFiles/arrays.dir/build

CMakeFiles/arrays.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/arrays.dir/cmake_clean.cmake
.PHONY : CMakeFiles/arrays.dir/clean

CMakeFiles/arrays.dir/depend:
	cd /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/arrays/cmake-build-debug/CMakeFiles/arrays.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/arrays.dir/depend

