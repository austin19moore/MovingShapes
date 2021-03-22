#ifndef EMPLOYEE_H
#define EMPLOYEE_H

typedef struct Employee_struct {
    
    char name[10];
    int id;
    double salary;
    
} Employee;

Employee* readData(char inputFile[], int* arraySize);

Employee getBestEmployee(Employee employees[], int arraySize);

void writeData(char outputFile[], Employee bestEmployee);

#endif