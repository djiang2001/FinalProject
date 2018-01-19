# FinalProject
## Group Members
Ahmed Imran
Dahong Jiang

## Project Title
Deblocked


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
### I. Creating an Array of Piece
-Many issues as the array of piece could not output background color
-Array of piece doesn't need background color(Realized this after making background color works)
-Created 2 Separate arrays, one that shows the visuals, the other of which will contain piece
### II. Creating Swap
-Still not done
-Updates piece but does not update to correct piece
