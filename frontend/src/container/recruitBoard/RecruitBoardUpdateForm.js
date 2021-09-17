import React, { useEffect, useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const RecruitBoardUpdateForm = (props) => {
  const recruitBoardId = props.match.params.recruitBoardId;

  const [recruitBoard, setRecruitBoard] = useState({
    recruitBoardContent: '',
  });

  useEffect(() => {
    fetch('http://localhost:8080/recruitBoard/' + recruitBoardId)
      .then((res) => res.json())
      .then((res) => {
        setRecruitBoard(res);
      });
  }, []);

  const changeValue = (e) => {
    setRecruitBoard({
      ...recruitBoard,
      [e.target.name]: e.target.value,
    });
  };
  const submitRecruitBoard = (e) => {
    e.preventDefault(); //submit이 action을 안 타고 자기 할 일을 그만함
    fetch('http://localhost:8080/recruitBoard/' + recruitBoardId, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json; charset=utf-8',
      },
      body: JSON.stringify(recruitBoard),
    })
      .then((res) => {
        console.log(1, res);
        if (res.status === 200) {
          return res.json();
        } else {
          return null;
        }
      })
      .then((res) => {
        console.log('정상', res);
        if (res !== null) {
          alert('글 작성 완료');
          props.history.push('/recruitBoard/' + recruitBoardId);
        } else {
          alert('작성에 실패하였습니다.');
        }
      });
  };
  return (
    <Form onSubmit={submitRecruitBoard}>
      <Form.Group className="mb-3" controlId="summernote">
        <Form.Label>글 내용</Form.Label>
        <Form.Control
          type="text"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="recruitBoardContent"
          value={recruitBoard.recruitBoardContent}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default RecruitBoardUpdateForm;
// return (
//   <Form onSubmit={submitRecruitBoard}>
//     <Form.Group className="mb-3" controlId="formBasicEmail">
//       <Form.Label>글 내용</Form.Label>
//       <Form.Control
//         type="text"
//         placeholder="내용을 입력해주세요."
//         onChange={changeValue}
//         name="recruitBoardContent"
//         value={recruitBoard.recruitBoardContent}
//       />
//     </Form.Group>

//     <Button variant="primary" type="submit">
//       Submit
//     </Button>
//   </Form>
// );
