#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[])
{
	int i;
	if(argc < 2) {
		printf("Usage : %s num\n", argv[0]);
		exit(1);
	}
	for(i=1; i<=atoi(argv[1]); i++) {
		printf("MyTask_%d!!\n", i);
		sleep(1);
	}
	return 0;
}
