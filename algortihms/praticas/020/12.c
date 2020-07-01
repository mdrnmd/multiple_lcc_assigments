#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MIN(a,b) ((a) < (b) ? (a) : (b))

int num_vars=0;
char * vars = NULL;

int num_cons=0;
struct cons {
	char a;
	char b;
} * cons = NULL;

/* 1 if everything is ok
 * 0 if something is wrong
 */
int
test(int num, char *order) {
	int i;
	char *s, *t;

#if DEBUG
	printf("HCK: test('%*.*s')\n", num, num, order);
#endif
	for (i=0; i<num_cons; i++) {
		s = memchr(order, cons[i].a, num);
		t = memchr(order, cons[i].b, num);
		if (!t) continue;
		if (!s) return 0;
		if (s > t) return 0;
	}
	return 1;
}

void
print(int num, char *order) {
	int i;
	for (i=0; i<num; i++) {
		printf("%c", order[i]);
	}
	printf("\n");
}

void
doit2(int num, char *order) {
	int i;

	if (num==num_vars) {
		print(num, order);
		return;
	}
	for (i=0; i<num_vars; i++) {
		if (memchr(order, vars[i], num)) continue;
		order[num] = vars[i];
		if (test(num+1,order)) {
#if DEBUG
			printf("HCK: num=%d, trying '%c'\n", num, vars[i]);
#endif
			doit2(num+1, order);
		}
	}
}

void
doit(void) {
	char order[30];
	doit2(0, &order[0]);
}

int
compar(const void *a, const void *b) {
	return *(char *)a - *(char *)b;
}

void
new_var(char a) {
	int i;

	for (i=0; i<num_vars; i++) {
		if (vars[i] == a) {
			return;
		}
	}
	vars = realloc(vars, (num_vars+1)*sizeof(char));
	vars[num_vars++] = a;
}

int
main(void) {
	char *buf1, *buf2;
	int i;

	buf1 = malloc(1024);
	buf2 = malloc(1024);

	fgets(buf1, 1024, stdin);
	if (buf1[0]=='#') {
		return 0;
	}
	while(buf1[strlen(buf1)-1]<'A' ||buf1[strlen(buf1)-1]>'Z') {
		buf1[strlen(buf1)-1] = '\0';
	}
	while(fgets(buf2, 1024, stdin)) {
		char *s;

		if (buf2[0]=='#') {
			break;
		}
		while(buf1[strlen(buf1)-1]<'A' ||buf1[strlen(buf1)-1]>'Z') {
			buf1[strlen(buf1)-1] = '\0';
		}
		for (i=0; i<MIN(strlen(buf1),strlen(buf2)); i++) {
			if (buf1[i] != buf2[i]) {
				new_var(buf1[i]);
				new_var(buf2[i]);
				cons = realloc(cons, (num_cons+1)*sizeof(struct cons));
				cons[num_cons].a = buf1[i];
				cons[num_cons].b = buf2[i];
				num_cons++;
				break;
			}
		}
		s = buf1;
		buf1 = buf2;
		buf2 = s;
	}
	qsort(vars, num_vars, sizeof(char), compar);
#if DEBUG
		printf("%d vars:", num_vars);
		for (i=0; i<num_vars; i++) {
			printf(" %c", vars[i]);
		}
		printf("\n%d constraints:", num_cons);
		for (i=0; i<num_cons; i++) {
			printf(" %c<%c", cons[i].a, cons[i].b);
		}
		printf("\n");
#endif
	doit();
	return 0;
}