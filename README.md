In my source code there have three part:domain;UI and Utility

The domain part is define the entities,like staff have uername,password, age, nextleader

The UI part is about the user interface and operation steps, like addstaff,assignstaff,dealleave

The Uitiliy part is about the tools for the system,like store all staffs information,check the login process and store the current login staff's information 


To run it in eclipse,You must choose operate.java in UI part




How to run:

This App contain seven staffs,

User:admin;psy1;psy2;psy3;psy4;psy5;psy6

Password:admin;psy1;psy2;psy3;psy4;psy5;psy6

This system have five parts:add;delete;assign;ask for leave; deal the request 

Each of them can add or delete or assign the staff and admin don't need to ask for leave,only the supervisor can deal the request and if one supervusor didn't hanlde the request ,the next supervisor would not receive the request.

As the system configure, admin is the boss of the department, he is the supervisor of psy1 and psy2 and psy1 is the supervisor of psy3,psy4,psy5,psy6.

If one staff request to leave,the supervisor of this employee must endorse the request or the request would not be accomplished.

For example, Staff X belong to the psy1, psy1 must endorse the request first and it pass to admin,if admin don't handle this request,there will be no hint when staff X login his system, when admin endorse this system,the request will success.

otherwise if  psy1 decilne this request, this request is refuesd.
 
