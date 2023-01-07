	extern printf
	section .data
t2: 	times 4 db 0
t0: 	times 4 db 0
t3: 	times 4 db 0
t1: 	times 4 db 0
t4: 	times 4 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
	section .text
	global main
main:
	mov rbp, rsp
	push rbp

	; 	t1 = 1
	mov eax,1
	mov [t1],eax
	; 	t0 = t1
	mov eax,[t1]
	mov [t0],eax
	; 	t3 = 2
	mov eax,2
	mov [t3],eax
	; 	t2 = t3
	mov eax,[t3]
	mov [t2],eax
	; 	goto e0
	; e1: skip
e1:
	; 	pmb foo
	; 	t8 = t5 + t6
	; //t8 -> rbp+-4
	; //t5 -> rbp+16
	; //t6 -> rbp+12
	mov eax,[rbp+16]
	mov ebx,[rbp+12]
	add ebx,eax
	mov [rbp+-4],ebx
	; 	t7 = t8
	; //t7 -> rbp+-8
	; //t8 -> rbp+-4
	mov eax,[rbp+-4]
	mov [rbp+-8],eax
	; 	rtn foo
	; 	t7 = 0
	; //t7 -> rbp+-8
	mov eax,0
	mov [rbp+-8],eax
	; 	rtn foo
	; e0: skip
e0:
	; e2: skip
e2:
	; 	pmb main
	; 	param_s: t0
	; 	param_s: t2
	; 	t9 = call foo
	; //t9 -> rbp+-4
	; 	t4 = t9
	; //t9 -> rbp+-4
	mov eax,[rbp+-4]
	mov [t4],eax
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
