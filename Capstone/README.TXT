------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Checkers
VERSION or DATE: 4/24/15
HOW TO START THIS PROJECT: Run the main method of the CheckersViewer class
AUTHOR: zmswartz

OVERVIEW:
This project runs a game of checkers with two human players. The game is played by clicking on a piece 
and then clicking on where you want that piece to go next. If anywhere else is clicked, it resets. The
player whose turn it is contantly printed out. Once the game is over, the winner is printed.

THE RULES:
The pieces can only move diagonally and can only jump one piece at a time. Any piece that is jumped is 
removed from the board. The game is over when there are only pieces of one team left. Regular pieces can
only move forward, but kings can move backwards. To get a king, a player must move their piece into the 
last row of their opponents side. If a player is able to jump the opponent at the beginning of their turn,
they must. This is what is meant by a forced move. Multiple jumps are also forced is possible.



This project uses inheritance with Piece and King, multiple arrays and 2D arrays including the storing
of the game board itself, as well as parts of all of first semesters topics (loops, objects, classes,
ect.) There was also use of an interface, MouseListener. The most challenging aspect of this project
was how I had to decide what classes did what and the entire project design. In this class, including the
tests and the AP test, we are always told what each method should do and what class it is a part of.
In this project though, I had to determine this and had to deal with the consequences of how I set
up each class. Alot of the logic in CheckersBoard class took a while for me to understand what needed
to be done.  