CREATE TABLE Workout (
workoutID INT PRIMARY KEY,
workoutDate  DATE,
workoutTime TIME,
duration TIME,
personalForm INT,
personalFeat INT,
note VARCHAR(100)
);

CREATE TABLE Exercise(
  exerciseID INT PRIMARY KEY,
  name VARCHAR(20),
  description VARCHAR(100) DEFAULT NULL
);

CREATE TABLE Equipment(
  equipmentID INT PRIMARY KEY,
  name VARCHAR(20),
  description VARCHAR(100)
);

CREATE TABLE ExerciseGroup(
  exerciseGroupID INT PRIMARY KEY,
  name VARCHAR(20),
  description VARCHAR(100)
);

CREATE TABLE ExerciseInWorkout(
  exerciseID INT,
  workoutID INT,
  exerciseFeat INT,
  weight INT,
  numberOfSets INT,
  PRIMARY KEY (exerciseID, workoutID),
  FOREIGN KEY(exerciseID)
      REFERENCES Exercise(exerciseID)
      ON DELETE CASCADE,
  FOREIGN KEY(workoutID)
      REFERENCES Workout(workoutID)
      ON DELETE CASCADE
);

CREATE TABLE ExerciseOnEquipment(
  equipmentID INT,
  exerciseID INT,
  PRIMARY KEY (equipmentID, exerciseID),
  FOREIGN KEY(equipmentID)
      REFERENCES Equipment(equipmentID)
      ON DELETE CASCADE,
  FOREIGN KEY(exerciseID)
      REFERENCES Exercise(exerciseID)
      ON DELETE CASCADE
);

CREATE TABLE ExerciseInGroup(
  exerciseID INT,
  exercisegroupID INT,
  PRIMARY KEY (exerciseID, exercisegroupID),
  FOREIGN KEY(exerciseID)
      REFERENCES Exercise(exerciseID)
      ON DELETE CASCADE,
  FOREIGN KEY(exerciseGroupID)
      REFERENCES ExerciseGroup(exerciseGroupID)
      ON DELETE CASCADE
);
