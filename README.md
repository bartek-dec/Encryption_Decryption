# Encryption-Decryption

### This is a console project to encrypt text to/decrypt text from Caesar cypher using 2 algorithms: 
### - unicode (it is based on a unicode table and shifts every sign by the specified number),
### - shift (it shifts each letter by the specified number according to its order in the alphabet in a circle).

### Program works with the following command-line arguments:
### - mode (enc - encryption, dec - decryption), if there is no -mode, the program should work in enc mode,
### - key (positive integer number), if there is no -key, the program should consider that key = 0,
### - data (string containing message), if there is no -data, the program should assume that the data is an empty string,
### - in (filename where original message is kept), if there is no -data, and there is no -in the program should assume 
### that the data is an empty string. If there are both -data and -in arguments, program should prefer -data over -in.
### - out (filename where encrypted/decrypted message is kept), if there is no -out argument, the program must print 
### data to the standard output,
### - alg (unicode or shift), if there is no -alg you should default it to shift.

### Not all arguments have to be present, also they may appear in a different order.

## Examples
### Example 1
### Input
### java Main -mode enc -in input.txt -out output.txt -key 5 -alg unicode

### This command must get data from the file input.txt, encrypt the data with the key 5, create a file called
### output.txt and write ciphertext to it.

### Example 2
### Input
### java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
### Output
### \jqhtrj%yt%m~ujwxpnqq&

### Example 3
### Input
### java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
### Output
### Welcome to hyperskill!

### Example 4
### Input
### java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
### Output
### Bjqhtrj yt mdujwxpnqq!

### Example 5
### Input
### java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
### Output
### Welcome to hyperskill!
