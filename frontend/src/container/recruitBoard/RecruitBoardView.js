import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';

const RecruitBoardView = (props) => {
  // console.log(1, props);
  const recruitBoardId = props.match.params.recruitBoardId;

  const [recruitBoard, setRecruitBoard] = useState({
    recruitBoardId: '',
    recruitBoardContent: '',
  });
  useEffect(() => {
    fetch('http://localhost:8080/recruitBoard/' + recruitBoardId)
      .then((res) => res.json())
      .then((res) => {
        setRecruitBoard(res);
      });
  }, []);

  const deleteRecruitBoard = () => {
    fetch('http://localhost:8080/recruitBoard/' + recruitBoardId, {
      method: 'DELETE',
    })
      .then((res) => res.text())
      .then((res) => {
        if (res === 'OK') {
          props.history.push('/recruitBoard/');
        } else {
          alert('삭제실패');
        }
      });
  };
  const updateRecruitBoard = () => {
    props.history.push('/recruitBoardUpdateForm/' + recruitBoardId);
  };
  return (
    <div>
      <h1>모임명</h1>
      <h3>모임장</h3>
      <hr />
      <h3>{recruitBoard.recruitBoardContent}</h3>
      <Button variant="warning" onClick={updateRecruitBoard}>
        수정
      </Button>{' '}
      <Button variant="danger" onClick={deleteRecruitBoard}>
        삭제
      </Button>
    </div>
  );
};

export default RecruitBoardView;
