### Main Features

- The main function of this ciphor tool app is to convert the input into designated ciphor output.
- The app takes three inputs:
	1. Message to be encoded: This input should be a non-empty string and must contain at least one letter. If an empty string is entered, "Missing Message" error would be expected. If a letterless string is entered, "Invalid Message" error would be applied.
	2. Target Alphabet: This input enables user to decide the output's target alphabet. This input should be a choice among "Normal", "Reverse", and "QWERTY". **Table 1** displayed an example of mapping the letters to the target alphabets.

	3. Shift Number: This input specifies how many target character should be shifted. The input should be an integer  >=1 and <26, otherwise an error of "Invalid Shift Number" would be thrown. **Table 2** displayed an example of mapping the letters to the target alphabets with shift number 3.

####Table1:
------------
| Original Text       |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|
| --------- |-|
| Normal  |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|
| Reverse |Z|Y|X|W|V|U|T|S|R|Q|P|O|N|M|L|K|J|I|H|G|F|E|D|C|B|A|
| QWERTY|Q|W|E|R|T|Y|U|I|O|P|A|S|D|F|G|H|J|K|L|Z|X|C|V|B|N|M|

####Table2:
------------
| Original Text       |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|
| --------- |-|
| Normal +3  |D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|A|B|C|
| Reverse +3 |W|V|U|T|S|R|Q|P|O|N|M|L|K|J|I|H|G|F|E|D|C|B|A|Z|Y|X|
| QWERTY +3|R|T|Y|U|I|O|P|A|S|D|F|G|H|J|K|L|Z|X|C|V|B|N|M|Q|W|E|

- The output of the inputs will return a string which all non-alphatic characters remain unchanged. Capitalization from the original message is preserved. 
EXAMPLE:
“Cat & Dog” shifted according to the Normal Alphabet and Shift Number 2 would be “Ecv & Fqi” (C+2, a+2, t+2, ‘ ‘, &, ‘ ‘, D+2, o+2, g+2).
“Cat & Dog” shifted according to the Reverse Alphabet and Shift Number 2 would be “Vxe & Ujr” (C->X+2, a->z+2, t->g+2, ‘ ‘, &, ‘ ‘, D->W+2, o->l+2, g->t+2).
- Error handling: If you have set multiple applicable errors, then all error marks will show next to the message input box or shift number box, but the error message will only show whenever the field has focus. There would be no output (empty) when error occurs.


### End