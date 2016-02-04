/* C source code from Intel to test out Intel Math Kernel Libary Reference Manual */

/* Multiplying Matrices Using dgemm */

#define min(x,y) (((x) < (y)) ? (x) : (y))

#include <stdio.h>
#include <stdlib.h>
#include "mkl.h"
