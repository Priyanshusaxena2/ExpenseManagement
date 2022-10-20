# ExpenseManagement

Run main method from Main class to execute the interactive program. Input/Output instructions are given below <br />

# Input
There will be 2 types of input:
Expense in the format: EXPENSE (user-id-of-person-who-paid) (no-of-users) (space-separated-list-of-users) <EQUAL/EXACT/PERCENT> (space-separated-values-in-case-of-non-equal) <br />
Show balances for a single user: SHOW (user-id) <br />
# Output
When asked to show balance for a single user. Show all the balances that user is part of <br />
Format: (user-id-of-x owes user-id-of-y): (amount) <br />
If there are no balances for the input, print No balances <br />
In cases where the user for which balance was asked for, owes money, they’ll be x. They’ll be y otherwise. <br />

SAMPLE INPUT <br />

SHOW u1 <br />
EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL <br />
SHOW u1 <br />
EXPENSE u1 1250 2 u2 u3 EXACT 370 880 <br />
EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20 <br />
SHOW u1 <br />

