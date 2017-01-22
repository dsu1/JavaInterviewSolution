# Monty Hall 5 Card Solution

I made this program as a solution to an interview question I had concerning the Monty Hall exercise using 5 cards.
The question was to explain the solution and write a program (which could be coded in several different languages) to demonstrate this solution.

#### For anyone unaware of the *original* form of this exercise, the Monty Hall question proceeds as such:
You are playing a game where you are given 3 cards face down. 
2 Cards are Red and 1 Card is Black. 
You must pick the Black card to win. 
Once you make your first pick, a Red card is revealed and you have the option of staying with your original choice or choosing the other card.
Do you change cards or do you stay?

#### The solution is quite simple:
In the first phase you have 1/3 odds of having chosen the correct card.
The part that trips people up is when the Red card is revealed.
With the Red card revealed, it seems the odds become 1/2 and choosing to stay or repick is moot because the odds of the outcomes are equal. That is not correct. 
The original odds of your first choice actually haven't changed. What has changed are the odds of the other card. Since a Red card has been flipped, the overall probablility of the other card increases to 2/3. This is because since we know for certain one card is Red and your first pick has a 1/3 chance of being Black, then the other card must have a 2/3 chance of being Black.

With this in mind, extending the problem to 5 cards is easy. Simply subsitute the 1/3 odds to 1/5 on your first pick. It's also necessary to mention when extra cards are added, the number of Red cards revealed is the (total_amount_of_cards - 2), so in my case, 3 Red cards are revealed of the total 5. Concluding that repicking in a 5 card Monty Hall exercise results in an 80% win rate.

#### Ending Notes
This program constructs a gui using JFrame and action listeners so the user can step through the logic that's behind the Monty Hall problem. 
The visual demonstration for each card you pick is hard coded, meaning the same 3 Red cards are revealed for each respective card.
A more accurate simulation of the game is ran 100,000 as stated in the program to demonstrate the odds in a more 'randomized' or 'natural' state.
