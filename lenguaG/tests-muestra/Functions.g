int a = 1;
int b = 2;
int c;
bool cond = true;

int foo(int a, int b, bool cond){
    if(cond){
        int c = a+b;
        return c;
    }
    return -(a+b);
}

main {
    c = foo(a,b, cond);
    // c = a+b;
    out(c);
    c = foo(a,b, not cond);
    out(c);
}