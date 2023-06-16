## *Exceptional users (required)*
We are creating a user management system. We need to be able to add users to our database. A user has a username and a password. The password should not be easy to guess, so it should consist of one lowercase character, one uppercase character and one number.

1. Create a static function that validates the password with the given constraint.
2. Make a new function that takes a username and password as input. It should print that the user is registered if the password meets the condition. This is a mock for our database.
3. Let the program ask for a username and a password.

```shell
$ java Users
Enter a username
> Sogyo
Enter a password
> Welcome123
Registered user Sogyo.
``` 
4. If the function is called with a password that does not meet the requirements, the user should not be registered. The function should agressively make public that invalid input was entered. Throw an exception to let the error propagate through the program. If you enter an invalid password, you should see the error message and a stacktrace.
5. The current output is not very user friendly. Use a catch clause to catch the exception and write a generic error message to the screen.

```shell
$ java Users
Enter a username
> Sogyo
Enter a password
> sogyo
Something has gone wrong.
``` 
6. You can use the catch block to handle user input, but this is not recommended. This anti-pattern is called “design by exception” and should be avoided. We therefore want a user-friendly check that does not use exceptions. Use the validation function that you’ve build before.

```shell
$ java Users
Enter a username
> Sogyo
Enter a password
> sogyo
This is not a valid password. Please enter a stronger password.
> Welcome123
Registered user Sogyo.
``` 

In normal use of the program, exceptions should not occur and invalid input is handled subtly. However, when a back-end function (like the one that registers the user) is called with invalid arguments, some programmer made the wrong assumptions regarding validation. In such an exceptional situation, an error must be raised and the program is allowed to crash.

### *Learning goals*
- Dealing with invalid input.
- Raising and handling exceptions.