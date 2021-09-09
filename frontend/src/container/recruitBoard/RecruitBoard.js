import React, { useEffect, useState } from 'react';
import RecruitBoardItem from '../../component/RecruitBoardItem';

const RecruitBoard = () => {
  const [recruitBoards, setRecruitBoards] = useState([]);

  // 함수 실행시 최초 한번 실행되는 것
  useEffect(() => {
    fetch('http://localhost:8080/recruitBoard')
      .then((res) => res.json())
      .then((res) => {
        console.log(1, res);
        setRecruitBoards(res);
      }); //비동기 함수
  }, []);

  return (
    <div className="mt-3">
      {recruitBoards.map((recruitBoard) => (
        <RecruitBoardItem
          key={recruitBoard.recruitBoardId}
          recruitBoard={recruitBoard}
        />
      ))}
    </div>
  );
};

export default RecruitBoard;
