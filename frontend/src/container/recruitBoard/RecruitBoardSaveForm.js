import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const RecruitBoardSaveForm = (props) => {
  const [recruitBoard, setRecruitBoard] = useState({
    recruitBoardContent: '',
  });

  const changeValue = (e) => {
    setRecruitBoard({
      ...recruitBoard,
      [e.target.name]: e.target.value,
    });
  };
  const submitRecruitBoard = (e) => {
    e.preventDefault(); //submit이 action을 안 타고 자기 할 일을 그만함
    fetch('http://localhost:8080/recruitBoard', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(recruitBoard),
    })
      .then((res) => {
        console.log(1, res);
        if (res.status === 201) {
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        if (res !== null) {
          alert('글 작성 완료');
          props.history.push('/recruitBoard');
        } else {
          alert('책 등록에 실패하였습니다.');
        }
      });
  };

  return (
    <Form onSubmit={submitRecruitBoard}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>글 내용</Form.Label>
        <Form.Control
          type="text"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="recruitBoardContent"
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default RecruitBoardSaveForm;
