int a = 1;
int b = 2;
int c;

int foo(int a, int b, bool cond){
    if(cond){
        int c = a+b;
        return c;
    }
    return 0;
}

main {
    c = foo(a,b, true);
    // c = a+b;
    out(c);
    c = foo(a,b, false);
    out(c);
}