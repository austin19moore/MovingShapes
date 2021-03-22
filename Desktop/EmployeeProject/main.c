#include <stdio.h>
#include "employee.h"

int main()
{
    int numEmployees = 0;
    char inputFile[20] = "a6-input.txt";
    char outputFile[20] = "a6-output.txt";
    Employee currBestEmployee;
    
    
    Employee* currEmployees = readData(inputFile, &numEmployees);
    
    currBestEmployee = getBestEmployee(currEmployees, numEmployees);
    
    writeData(outputFile, currBestEmployee);

    return 0;
}