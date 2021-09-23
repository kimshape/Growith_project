import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

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
        console.log('정상', res);
        if (res !== null) {
          alert('글 작성 완료');
          props.history.push('/recruitBoard');
        } else {
          alert('작성에 실패하였습니다.');
        }
      })
      .catch((error) => {
        console.log('실패', error);
      });
  };

  return (
    <Form onSubmit={submitRecruitBoard}>
      <Form.Group className="mb-3">
        <Form.Label>글 내용</Form.Label>
        <Form.Control
          type="Lob"
          placeholder="내용을 입력해주세요."
          onChange={changeValue}
          name="recruitBoardContent"
        />
      </Form.Group>
      <CKEditor
        editor={ClassicEditor}
        data="<p>Hello from CKEditor 5!</p>"
        onReady={(editor) => {
          // You can store the "editor" and use when it is needed.
          console.log('Editor is ready to use!', editor);
        }}
        onChange={(event, editor) => {
          const changeValue = (e) => {
            setRecruitBoard({
              ...recruitBoard,
              [e.target.name]: e.target.value,
            });
          };
          console.log({ event, editor, changeValue });
        }}
        name="recruitBoardContent"
        onBlur={(event, editor) => {
          console.log('Blur.', editor);
        }}
        onFocus={(event, editor) => {
          console.log('Focus.', editor);
        }}
      />
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default RecruitBoardSaveForm;
