# FinalProject
## Group Members
Ahmed Imran
Dahong Jiang

## Project Title
Unblocked

## Instructions
1. Compile Start.java
2. Run Start
3. Once in game, get score to at the the goal in order to win
4. If you run out of moves and did not reach the goal, you will lose.
5. If you pass the goal you will win.

## I. Project Idea
 - Create a match three puzzle game similar to Candy Crush Saga
-There will be an grid of randomly generated colored blocks.
Blocks 
-Can switch with other blocks 1 unit away
-Returns to original position when not at least three blocks horizontally or vertically are the same color.
-If block are the same, destroy all connected blocks of the same color and move all blocks from above down to fill in the gap.
-Add number of moves
-Points for different chains
-A point threshold that you have to reach in the number of moves
-If you wish to beg, click the beg button, and click one of the blocks. Beware, if you have no Begs left you may or may not lose a move!In addition, like always, begging may or may not give you the outcome you want.
-In order to get more beg chances, simply break combos. Some combos will give you beg chances.
-If you wish to restart, you can click give up.

## II. Critical Features

### I
-Randomly generate a grid of different colored blocks

### II 
-Pieces will swap

### III
-Pieces will be destroyed when chained at least 3 (Haven't done)

### IV
-Pieces will drop down

### V 
-When grid is generated, it will check for chains 

## III. To Be Added Later Features
-Difficulty, which will change goal point

## Instructions

## IV.Development Log
### 1/3/18
Created Deblocked.java -Dahong
Added .gitignore - Ahmed
### 1/4/18 
Created initial GUI and tested mouseAdapter - Dahong
### 1/5/18 
Tried to create grid on GUI and made it resizable - Dahong
Created Block.java to add to future GUI grid - Ahmed
### 1/6/18 
Added JLabels score, moves, and difficulty - Dahong
### 1/7/18 
Tried to display grid, but no success - Dahong
Added Getters and Setters and constructors to block created Grid.java to fill with blocks - Ahmed
### 1/8/18
Tried to use Graphics to create Grid, but no success - Dahong
Tried to display grid using paint, but no success - Ahmed
### 1/9/18
Implemented mouselistener to Deblocked.java for future functionality - Dahong
Created new directory for images and added necessary pictures for the blocks - Ahmed
### 1/10/18
Began to add borders for future array of images - Dahong
Created new constructor for blocks and added JLabel functionality to blocks - Ahmed
### 1/11/18
Made mouseListener return x and y coordinates and color of block clicked - Dahong
Worked on displaying the icons in the grid and making them visible - Ahmed
Deblocked.java renamed to Grid.java, merge conflicts solved, and random color generator created - both
### 1/12/18
GUI displayed one pink square with border and resolved merge conflicts - Dahong
Continued working on displaying icons - Ahmed
Only one square was visible, but mouselistener returned hidden block properties in the appropriate locations
### 1/13/18
Tried to resolve looping problem by renaming block.java as piece.java and adding toString(), but no success. -Dahong  
### 1/14/18
Tried switching hidden blocks, but got errors, and added test for JLabel icons and mouse clicks - Dahong
Fixed merge conflicts and deleted excess code in Grid.java. Successfully fixed mouse click errors and succeeded in creating and displaying blocks board on GUI. Afterwards changed code to include universal file paths to create the Grid. - Ahmed
### 1/15/18
Fixed score, moves, and threshold to appear on bottom of board. Started working on finding matches, but no success. Allowed players to select a block. Created Coords class to store coordinates. - Dahong
Worked on swapping blocks and succeeded in making first few swaps accurate, however swap remained bugged. Adapted Grid.java to incorporate methods from Coords.java - Ahmed
Read me updated
### 1/16/18
Reformatted code to make it look better and revised faulty code - Dahong
Fixed merge conflicts and added Horizontal check and vertical check to detect if swaps are valid and form combos. Added function make grid to reupdate grid after swaps. Tried to fix swap using reupdate grid method by clearing Container and adding all blocks in the new positions, but only works for one swap. Attempted to fix bugs in mouse click, but failed - Ahmed
### 1/17/18
Fixed swap for blocks, but not visually, and added buffer in case it's necessary - Dahong
Created methods to store all vertical and horizontal chains found in the grid - Ahmed
### 1/18/18
Final fixes to swap so that it corrects visually, and fixed moves to decrease every time a swap occurs. Fixed some of destroy chains and find chains methods. Destroy now properly destroys chains of 5. - Dahong
Created destroy chains method to turn chains of blocks stored at coordinates in the find chains method and array to black, but certain bugs existed that turned extra blocks into black. Fixed destroy which now properly destroys chains of 4 and 5. - Ahmed 
### 1/19/18
Reworked Piece so that it extends JButton
### 1/20/18
Falling down action works and blocks can be destroyed. Swapping is a little bugged.
### 1/21/18
Added intro, beg, restart, and ending. Added storyline. Fall down works much better.
