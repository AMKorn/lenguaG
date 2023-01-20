int[] a = [1,2];
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
    c = foo(a[0], a[1], cond);
    // c = a+b;
    out(c);
    c = foo(a[0], a[1], not cond);
    out(c);
}