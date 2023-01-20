	extern printf
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

	; 	goto e0
	jmp e0
	; e1: skip
e1:
	; 	pmb foo
	; 	if t6=0 goto e2
	mov eax,[rsp+32]
	mov ebx,0
	cmp eax,ebx
	je e2
	; 	t8 = t4 + t5
	mov eax,[rsp+16]
	mov ebx,[rsp+24]
	add ebx,eax
	mov [rsp+-12],ebx
	; 	t7 = t8
	mov eax,[rsp+-12]
	mov [rsp+-4],eax
	; 	rtn foo: t7
	mov eax,[rsp+-4]
	mov [rsp+8],eax
	jmp e3
	; e2: skip
e2:
	; 	t9 = t4 + t5
	mov eax,[rsp+16]
	mov ebx,[rsp+24]
	add ebx,eax
	mov [rsp+-8],ebx
	; 	t9 = -t9
	mov eax,[rsp+-8]
	neg eax
	mov [rsp+-8],eax
	; 	rtn foo: t9
	mov eax,[rsp+-8]
	mov [rsp+8],eax
	jmp e3
	; e3: skip
e3:
	ret
	; e0: skip
e0:
	; e4: skip
e4:
	; 	pmb main
	; 	param_s: t3
	xor rax,rax
	mov eax,[t3]
	push rax
	; 	param_s: t1
	xor rax,rax
	mov eax,[t1]
	push rax
	; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	; 	t10 = call foo
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-8],ebx
	; 	t2 = t10
	mov eax,[rsp+-8]
	mov [t2],eax
	; 	out: t2
	mov rdi,fmtOutInt
	mov rsi,[t2]
	mov rax, 0
	call printf
	; 	t3 = not t3
	mov eax,[t3]
	not eax
	mov [t3],eax
	; 	param_s: t3
	xor rax,rax
	mov eax,[t3]
	push rax
	; 	param_s: t1
	xor rax,rax
	mov eax,[t1]
	push rax
	; 	param_s: t0
	xor rax,rax
	mov eax,[t0]
	push rax
	; 	t11 = call foo
	push rax
	call e1
	pop rbx
	pop rax
	pop rax
	pop rax
	mov [rsp+-4],ebx
	; 	t2 = t11
	mov eax,[rsp+-4]
	mov [t2],eax
	; 	out: t2
	mov rdi,fmtOutInt
	mov rsi,[t2]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
	section .data
t1:	dd 2
t0:	dd 1
t3:	dd -1
t2:	dd 0
fmtOutInt: db "%d",10,0
