# To-Do-List
This is a simple command line application that allows users to manage and track their tasks like adding tasks into a list, removing tasks, updating, marking as done or filtering and listing by date or by a project. 

## Usage

```bash
https://github.com/MadinaArtykova/IP.git
cd IP
```


## Manual

### Menu of the task manager

```>> Welcome to TO-DO List```

```==========================================```

```>> You have 4 task TODO and 1 task DONE!```

```==========================================```

```>>  Pick an option: ```

```>>  1 - Show Task List (by date, by project)```

```>>  2 - Add New Task```

```>>  3 - Edit Task (update, mark as done)```

```>>  4 - Remove Task```

```>>  0 - Save and Quit```

```>>  Enter your menu choice:```


#### Menu options
#### Show Task List

In order to list tasks, you should pick ****_>> 1 -_**** from the main menu. 

After this step you will see the list of tasks. In order to see the list of tasks sorted by date or project,
follow one of the next steps:
**_1. Show tasks ordered by date:_** Will list all tasks sorted by date.
**_2. Show tasks ordered by project:_** Will list all tasks sorted by project.


#### Add Task

In order to add a new task, you select ****>> 2 -**** from the main menu. 

| Input    	| Type                	| Mandatory 	| Description                                                                                                    	|
|----------	|---------------------	|-----------	|----------------------------------------------------------------------------------------------------------------	|
|  Date 	| Local Date          	| YES       	| A date (YYYY-MM-DD)                 	|
| Project 	| boolean, String      	| YES       	| A short name of the project.                                                                               	|
| Title  	| String            	| YES       	| A short description of the task 	|


#### Edit Task (update, mark as done)

In order to update or mark as done choose the ****>> 3 -**** from the main menu. 
You have 2 post options:

**_1. Update          :_** Will update the task record with given Task number.

**_2. Mark as Done    :_** Will update the task status as "Done" with given Task number.

Task number is mandatory input for this actions. 

#### Remove Task

Chose the option **_>> 4 - Remove Task :_** will delete the task record with given task number.

#### Save and Quit

In order yo save the changes and quit the application, you should pick **>>  0 - Save and Quit** option from the menu.
It will save the changes you have made and quit the application.
Finally, the sentence on top of the menu shows the number of tasks counted by status.

```>> You have 4 task TODO and 1 task DONE!```