# KalturaApiTask
Kaltura api testing exercise solution

Hey Alon!

Some notes and guiding for the exercise solution:

1. 
the project is a standard maven type

2.
the runner is TestNG

3
to start the execution just run the maven ApiTests.xml file in the project root.

4.
a parralell testing option can be set and working fine but then the console output is not synced... it should still be optimized with log4j appenders to handle correct and distinct logging for each thread.
to set the parralelization just update the thread-count parameter in the ApiTests.xml:
for example set it to 10 tests methods for iteration.
<suite name="ApiTestingSuite" parallel="methods" thread-count="10" verbose="-1">
I kept the "thread-count" for 1 to keep the console reporting tracking easy...

5.
 the testing framework idea was generally using json templates of post requests or response for the tested actions, each such template is like a skeleton with default values to serve as the base structure and then serializing/desirilizing them into pojo objects (using gson) then back to json and vice versa.
when the object is created the test can then manipulate it for its needs for varios inputs (for example replacing username with dummy to test invalid username login), converts it back to json and sends it as the body to the post action.
in this way its much easier to handle test data.

6.
 each test stands for its own and is not depended in other tests execution but starts from the begining. therefor, the tests are currently quite long and can surely be optimized...
for the exercise, the helpers section was created to save some code...
for example:
if register action was tested already, there is no need to see the register code again in login test.
I did not have much time to implement all so just mentioned that to get the idea... a steps package would be the best approach to wrap all services and actions and when a test covers one of them, it will be allowed to be refred as helpable ;)
In the end the tests should as readable and understable as possible and not just look like bunch of code.

6.1
 I used a lot of constants and wrappers all over the place to prevent as much hard coded values as I could.

7.
 all the tests are passing and working correctly except the test "validateBasicSuccessfulUpdate" under "com.kalturaApis.test.services.ottUser.actions.UpdateTestsUsingHelper" class.
this test fails on "Service Forbidden" although I think I tried all variations of supplying the correct data (id , username , externalID, the updated value)...
You can review that in the tests I guess :)
the API documentation did not help with that error so I had to guess what to supply when updating the KalturaOTTUser.
isnt the new registered users ID and the user object should enough?

8.
I have tried to comment as much as I could for you to understand the code. its really just the basics, so much more to optimize there and to do...
did not have much time but i really wanted to do that in the most proffessional way that I could in this short time that I had.
It was really interesting and i enjoyed that.
Hope you will find it well and easy to review and that we can continue working on that together in the future :-)

feel free to call me for any questions.

Thanks,
Irmi
