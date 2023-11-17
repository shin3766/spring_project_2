package com.sparta.springproject2.service;

import com.sparta.springproject2.dto.CommentRequestDto;
import com.sparta.springproject2.dto.CommentResponseDto;
import com.sparta.springproject2.entity.Comment;
import com.sparta.springproject2.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // CREATE: Comment 만들기
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        // RequestDto -> Entity
        Comment comment = new Comment(requestDto);

        // DB 저장
        Comment saveComment = commentRepository.save(comment);

        //Entity -> ResponseDto
        CommentResponseDto commentResponseDto = new CommentResponseDto(saveComment);

        return commentResponseDto;
    }

    // READ: Comment 읽기
    public List<CommentResponseDto> getComments() {
        // DB 조회
        return commentRepository.findAllByOrderByCreatedAtDesc().stream().map(CommentResponseDto::new).toList();
    }

    // UPDATE: Comment 업데이트하기
    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto) {
        // 해당 comment가 DB에 존재하는지 확인
        Comment comment = findComment(id);

        // todo 내용 수정
        comment.update(requestDto);

        return id;
    }

    // DELETE: Comment 삭제하기
    public Long deleteComment(Long id) {
        // 해당 comment가 DB에 존재하는지 확인
        Comment comment = findComment(id);

        // todo 내용 수정
        commentRepository.delete(comment);

        return id;
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 comment는 존재하지 않습니다.")
        );
    }
}
