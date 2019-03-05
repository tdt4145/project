CREATE TABLE workout (
workoutID INT PRIMARY KEY,
workoutDate
duration INT,
personalForm INT,
personalFeat INT,
note VARCHAR(100)
);

CREATE TABLE exercise(
  exerciseID INT PRIMARY KEY,
  exerciseName VARCHAR(20),
  description VARCHAR(100)
);

CREATE TABLE equipment(
  equipmentID INT PRIMARY KEY,
  equipmentName VARCHAR(20)
);

CREATE TABLE exerciseGroup(
  groupID INT PRIMARY KEY
);

CREATE TABLE exerciseInWorkout(
  exerciseID INT,
  workoutID INT,
  weight INT,
  sets INT,
  description VARCHAR(100),
  PRIMARY KEY (exerciseID, workoutID),
  FOREIGN KEY(exerciseID)
      REFERENCES exercise(exerciseID)
      ON DELETE CASCADE,
  FOREIGN KEY(workouID)
      REFERENCES workout(workoutID)
      ON DELETE CASCADE
);

CREATE TABLE equipmentInExercise(
  equipmentID INT,
  exerciseID INT,
  PRIMARY KEY (equipmentID, exerciseID),
  FOREIGN KEY(equipmentID)
      REFERENCES equipment(equipmentID)
      ON DELETE CASCADE,
  FOREIGN KEY(exerciseID)
      REFERENCES exercise(exerciseID)
      ON DELETE CASCADE
);

CREATE TABLE exerciseInGroup(
  exerciseID INT,
  groupID INT,
  PRIMARY KEY (exerciseID, groupID),
  FOREIGN KEY(exerciseID)
      REFERENCES exercise(exerciseID)
      ON DELETE CASCADE,
  FOREIGN KEY(groupID)
      REFERENCES exerciseGroup(groupID)
      ON DELETE CASCADE
);
