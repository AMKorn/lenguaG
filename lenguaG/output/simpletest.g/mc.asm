	extern printf
	extern scanf
	section .data
t2: 	times 4 db 0
t0: 	times 4 db 0
t3: 	times 4 db 0
t1: 	times 4 db 0
t4: 	times 4 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
fmtInInt:  db "%d", 0
fmtInChar:  db "%s", 0
	section .text
	global main
main:
	mov rbp, rsp
	push rbp

	; 	t1 = 2
	mov eax,2
	mov [t1],eax
	; 	t0 = t1
	mov eax,[t1]
	mov [t0],eax
	; 	t3 = 3
	mov eax,3
	mov [t3],eax
	; 	t2 = t3
	mov eax,[t3]
	mov [t2],eax
	; e0: skip
e0:
	; 	pmb main
	; 	in: t0
	mov rsi,t0
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	in: t2
	mov rsi,t2
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	t5 = t0 + t2
	mov eax,[t0]
	mov ebx,[t2]
	add ebx,eax
	mov [rbp-4],ebx
	; 	t4 = t5
	mov eax,[rbp-4]
	mov [t4],eax
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
