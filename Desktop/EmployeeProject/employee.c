#include <stdio.h>
#include "employee.h"

Employee* readData(char inputFile[], int* arraySize) {
    FILE* inFile = fopen(inputFile, "r");
    int i;
    char c;
    int count = 1;
    
    for (c = getc(inFile); c != EOF; c = getc(inFile)) {
        if (c == '\n')
            count = count + 1; 
    }
        rewind(inFile);
        *arraySize = count;
        
        Employee employees[*arraySize];
        
    for (i = 0; i < *arraySize; i++) {
        fscanf(inFile, "%s %d %lf", employees[i].name, &employees[i].id, &employees[i].salary);
    }
    fclose(inFile);
    
    Employee* employeesPoint = employees;
    return employeesPoint;
}

Employee getBestEmployee(Employee employees[], int arraySize) {
    int i;
    Employee bestEmployee = employees[0];
    
    for (i = 0; i < arraySize; i++) {
        if (employees[i].salary > bestEmployee.salary) {
            bestEmployee = employees[i];
        }
        
    }
    return bestEmployee;
}

void writeData(char outputFile[], Employee bestEmployee) {
    FILE* outFile = fopen(outputFile, "w");
    fprintf(outFile, "%s %d %d", bestEmployee.name, bestEmployee.id, (int)bestEmployee.salary);
    fclose(outFile);
}