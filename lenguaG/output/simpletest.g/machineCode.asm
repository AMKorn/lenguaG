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

	;;;; 	t1 = 1
	mov eax,1
	mov [t1],eax
	;;;; 	t0 = t1
	mov eax,[t1]
	mov [t0],eax
	;;;; 	t3 = 2
	mov eax,2
	mov [t3],eax
	;;;; 	t2 = t3
	mov eax,[t3]
	mov [t2],eax
	;;;; 	goto e0
	jmp e0
	;;;; e1: skip
e1:
	;;;; 	pmb foo
	;;;; 	if t7=0 goto e2
	; //t7 -> rsp+32
	;;;; 	t9 = t5 + t6
	; //t9 -> rsp+-8
	; //t5 -> rsp+16
	; //t6 -> rsp+24
	mov eax,[rsp+16]
	mov ebx,[rsp+24]
	add ebx,eax
	mov [rsp+-8],ebx
	;;;; 	t8 = t9
	; //t8 -> rsp+-12
	; //t9 -> rsp+-8
	mov eax,[rsp+-8]
	mov [rsp+-12],eax
	;;;; 	rtn foo: t8
	; //t8 -> rsp+-12
	mov eax,[rsp+-12]
	mov [rsp+8],eax
	jmp e3
	;;;; e2: skip
e2:
	;;;; 	t10 = 0
	; //t10 -> rsp+-4
	mov eax,0
	mov [rsp+-4],eax
	;;;; 	rtn foo: t10
	; //t10 -> rsp+-4
	mov eax,[rsp+-4]
	mov [rsp+8],eax
	jmp e3
	;;;; e3: skip
e3:
	ret
	;;;; e0: skip
e0:
	;;;; e4: skip
e4:
	;;;; 	pmb main
	;;;; 	t11 = -1
	; //t11 -> rsp+-12
	mov eax,-1
	mov [rsp+-12],eax
	;;;; 	param_s: t11
	; //t11 -> rsp+-12
	xor rax,rax
	mov eax,[rsp+-12]
	push rax
	;;;; 	param_s: t2
	xor rax,rax
	mov eax,[t2]
	push rax
	;;;; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	;;;; 	t12 = call foo
	; //t12 -> rsp+-8
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-8],ebx
	;;;; 	t4 = t12
	; //t12 -> rsp+-8
	mov eax,[rsp+-8]
	mov [t4],eax
	;;;; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf
	;;;; 	t13 = 0
	; //t13 -> rsp+-4
	mov eax,0
	mov [rsp+-4],eax
	;;;; 	param_s: t13
	; //t13 -> rsp+-4
	xor rax,rax
	mov eax,[rsp+-4]
	push rax
	;;;; 	param_s: t2
	xor rax,rax
	mov eax,[t2]
	push rax
	;;;; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	;;;; 	t14 = call foo
	; //t14 -> rsp+-16
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-16],ebx
	;;;; 	t4 = t14
	; //t14 -> rsp+-16
	mov eax,[rsp+-16]
	mov [t4],eax
	;;;; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
