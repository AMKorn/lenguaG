int i = 0;

main {
    if (i < j) { // Semantic error: non-declared variable
        out(i);
    } else {
        out(j);
    }
}