import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';

const RecruitBoardView = (props) => {
  console.log(1, props);
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

  return (
    <div>
      <h1>모임명</h1>
      <h3>모임장</h3>
      <hr />
      <h3>{recruitBoard.recruitBoardContent}</h3>
      <Button variant="warning">Warning</Button>{' '}
      <Button variant="danger">Danger</Button>
    </div>
  );
};

export default RecruitBoardView;
