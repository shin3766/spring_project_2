package com.sparta.springproject2.service;

import com.sparta.springproject2.dto.TodoRequestDto;
import com.sparta.springproject2.dto.TodoResponseDto;
import com.sparta.springproject2.entity.Todo;
import com.sparta.springproject2.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    //----------------------------------------------------------------------
    // CREATE: todo 만들기---------------------------------------------------
    //- 토큰을 검사하여, 유효한 토큰일 경우에만 할일 작성 가능
    //- `할일 제목`,`할일 내용`, `작성일`을 저장할 수 있습니다. (~~작성자명, 비밀번호)~~
    //- 할일 제목, 할일 내용을 저장하고
    //- 저장된 할일을 Client 로 반환하기(username은 로그인 된 사용자)
    //----------------------------------------------------------------------
    // READ(selected): todo 선택 조회
    //- 선택한 ~~게시글~~ 할일 의 정보를 조회할 수 있습니다.
    //- 반환 받은 할일 정보에는 `할일 제목`,`할일 내용`, `작성자` , `작성일`정보가 들어있습니다.
    //- ~~반환 받은 게시글의 정보에 비밀번호는 제외 되어있습니다.~~
    //-------------------------------------------------------------------------
    //------------------------------------------------------------------------
    //---------------------------------------------------------------------
    // READ(all): todo 전체 조회
    //- 등록된 할일 전체를 조회할 수 있습니다.
    //- 회원별로 각각 나누어서 할일 목록이 조회됩니다.
    //- 반환 받은 할일 정보에는 `할일 제목`, `작성자` , `작성일`, `완료 여부`정보가 들어있습니다.
    //- 조회된 할일 목록은 작성일 기준 내림차순으로 정렬 되어있습니다.
    //-----------------------------------------------------------------------
    //- 선택한 ~~게시글~~ 할일카드의 `제목`, `작성 내용`을 수정할 수 있습니다. (~~작성자명~~)
    //    - 토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능
    //    - 할일 제목, 할일 내용을 수정하고 수정된 할일 정보는 Client 로 반환됩니다.
    //    - ~~서버에 게시글 수정을 요청할 때 비밀번호를 함께 전달합니다.~~
    //    - ~~선택한 게시글의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 수정이 가능합니다.~~
    //- 수정된 ~~게시글~~ 할일의 정보를 반환 받아 확인할 수 있습니다.
    //    - 반환 받은 할일 정보에는 `할일 제목`,`할일 내용`, `작성자` , `작성일`정보가 들어있습니다.
    //    - ~~반환 받은 게시글의 정보에 비밀번호는 제외 되어있습니다.~~
    // UPDATE: todo 업데이트하기

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    // CREATE: todo 만들기---------------------------------------------------
    //- 토큰을 검사하여, 유효한 토큰일 경우에만 할일 작성 가능
    //- `할일 제목`,`할일 내용`, `작성일`을 저장할 수 있습니다. (~~작성자명, 비밀번호)~~
    //- 할일 제목, 할일 내용을 저장하고
    //- 저장된 할일을 Client 로 반환하기(username은 로그인 된 사용자)
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        // RequestDto -> Entity
        Todo todo = new Todo(requestDto);

        // DB 저장
        Todo saveTodo = todoRepository.save(todo);

        //Entity -> ResponseDto
        TodoResponseDto todoResponseDto = new TodoResponseDto(saveTodo);

        return todoResponseDto;
    }
    //----------------------------------------------------------------------


    public List<TodoResponseDto> getTodos() {
        // DB 조회
        return todoRepository.findAllByOrderByModifiedAtDesc().stream().map(TodoResponseDto::new).toList();
    }


    @Transactional
    public Long updateTodo(Long id, TodoRequestDto requestDto) {
        // 해당 todo가 DB에 존재하는지 확인
        Todo todo = findTodo(id);

        // todo 내용 수정
        todo.update(requestDto);

        return id;
    }


    // DELETE: todo 지우기
    public Long deleteTodo(Long id) {
        // 해당 todo가 DB에 존재하는지 확인
        Todo todo = findTodo(id);

        // todo 삭제
        todoRepository.delete(todo);

        return id;
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 todo는 존재하지 않습니다.")
        );
    }
}
