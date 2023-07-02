import React from 'react';
import styled from 'styled-components';
import backgroundVideo from './assets/backgroundVideo-1.mp4';

const VideoContainer = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: -1;
`;

const BackgroundVideo = () => {
  const videoRef = React.useRef(null);

  React.useEffect(() => {
    // Set the desired playback rate once the video is loaded
    videoRef.current.playbackRate = 0.35;
  }, []);

  return (
    <VideoContainer>
      <video autoPlay muted loop id="background-video" ref={videoRef}>
        <source src={backgroundVideo} type="video/mp4" />
        {/* Add additional <source> tags for different video formats if needed */}
      </video>
    </VideoContainer>
  );
};

export default BackgroundVideo;
