import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';
import { ListGroup, Card } from 'react-bootstrap';

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
      <div className="card">
        <div className="card-body">
          <textarea className="form-control" rows="1"></textarea>
        </div>
        <div className="card-footer">
          <Button
            // style={{ backgroundColor: '#AFE2E2', Color: '#565656' }}
            variant="primary"
          >
            댓글작성
          </Button>
        </div>
      </div>
      <br />
      <div className="card">
        <div className="card-header">댓글리스트</div>
        <Card id="comment--box" style={{ width: 'auto' }}>
          <ListGroup id="comment--1" variant="flush">
            <ListGroup.Item
              className="d-flex"
              style={{
                flexDirection: 'row',
                justifyContent: 'space-between',
              }}
            >
              <div>댓글내용</div>
              <div className="d-flex">
                <div style={{ fontFamily: 'serif' }}>
                  작성자 : 김형태 &nbsp;
                </div>
                <Button variant="danger">삭제</Button>
              </div>
            </ListGroup.Item>
          </ListGroup>
        </Card>
      </div>
    </div>
  );
};

export default RecruitBoardView;
