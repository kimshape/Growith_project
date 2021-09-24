import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';
import { ListGroup, Card } from 'react-bootstrap';
// import jquery from 'jquery';
// import $ from 'jquery';

const RecruitBoardView = (props) => {
  // console.log(1, props);
  const recruitBoardId = props.match.params.recruitBoardId;
  // const replyId = props.match.params.replyId;

  const [recruitBoard, setRecruitBoard] = useState({
    recruitBoardId: '',
    recruitBoardContent: '',
  });
  // const [replies, setReplies] = useState({
  //   replyId: '',
  //   replyContent: '',
  // });
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
          <Button variant="primary">댓글작성</Button>
        </div>
      </div>
      <br />
      <div className="card">
        <div className="card-header">댓글리스트</div>
        <Card id="reply--box" style={{ width: 'auto' }}>
          <ListGroup id="reply--1" variant="flush">
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
          <ListGroup id="reply--2" variant="flush">
            <ListGroup.Item
              className="d-flex"
              style={{
                flexDirection: 'row',
                justifyContent: 'space-between',
              }}
            >
              <div>댓글내용1</div>
              <div className="d-flex">
                <div style={{ fontFamily: 'serif' }}>작성자 : kim &nbsp;</div>
                <Button variant="danger">삭제</Button>
              </div>
            </ListGroup.Item>
          </ListGroup>
          <ListGroup id="reply--3" variant="flush">
            <ListGroup.Item
              className="d-flex"
              style={{
                flexDirection: 'row',
                justifyContent: 'space-between',
              }}
            >
              <div>댓글내용2</div>
              <div className="d-flex">
                <div style={{ fontFamily: 'serif' }}>
                  작성자 : kimshape &nbsp;
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
