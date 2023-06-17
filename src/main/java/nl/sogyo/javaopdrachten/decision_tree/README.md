## *Decision tree (Required)*

A decision tree is a graph consisting of nodes and edges, where each node is a question and each edge is a decision. The goal of this exercise is to create a program that has a decision tree as input from a file and executes this for the user.

Example file:

1. N2, Is de rand van het blad te omschrijven als gezaagd of gekarteld?
2. N5, Is het blad gelobd of heeft het blad lobben?
3. N6, Es
4. N7, Els
5. N8, Esdoorn
6. N9, Berk
7. N0, Eik
8. N3, Is de rand dubbel gezaagd ipv enkelvoudig gezaagd?
9. NA, Beech
10. N5, NA, No
11. N3, N7, No
12. N1, N6, Yes
13. N1, N2, No
14. N2, N3, Yes 
15. N2, N4, No

### *File Format*

The file is a UTF-8 text file that has an edge or a node on each line. A node consists of a name and a question. An edge consists of an origin node, a destination node, and an answer. Node and edge are mixed throughout the file.

### *Exercises*

1. Write a program that can read in a file in the above-mentioned format. It should also translate the lines to node and edge objects. The nodes should be built in a way that they represent the problem at hand, the decision tree.
2. Execute the decision tree by asking the questions from the decision tree and navigating through the tree until an answer is found. The starting question is the node which is not a destination for any edge and an answer is a node where no edges originate from.