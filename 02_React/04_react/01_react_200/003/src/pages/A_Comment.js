// A_Comment.js : 자식
// rfce
import React from "react";
// Comment.css import
import "../assets/Comment.css";

function A_Comment() {
  return (
    <div className="wrapper">
      <div className="imageContainer">
        <img
          src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png"
          className="image"
        />
      </div>

      <div className="contentContainer">
        <span className="nameText">{}</span>
        <span className="commentText">{}</span>
      </div>
    </div>
  );
}

export default A_Comment;
