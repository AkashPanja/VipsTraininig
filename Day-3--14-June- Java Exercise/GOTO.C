//Java doesn't supprot GOTO statements
//GOTO Example

#include<stdio.h>

void main () {

   int number = 10;

   START:do {
      if( number == 15) {
	 number = number + 1;
	 goto START;
      }

      printf("Value is: %d\n", number);
      number++;

   }while( number < 20 );
   getch();
}