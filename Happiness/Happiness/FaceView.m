//
//  FaceView.m
//  Happiness
//
//  Created by Hanmoi Choi on 2/01/13.
//  Copyright (c) 2013 edu.unimelb.csse. All rights reserved.
//

#import "FaceView.h"
#define DEFAULT_SCALE 0.90

@implementation FaceView

@synthesize scale = _scale;

-(void) setup{
    self.contentMode = UIViewContentModeRedraw;
}
-(void)awakeFromNib {
    [self setup];
}
- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        [self setup];
    }
    return self;
}

- (CGFloat)scale {
    if(_scale){
        return _scale;
    }
    else{
        return DEFAULT_SCALE;
    }
}

- (void)setScale:(CGFloat)scale {
    if(_scale != scale){
        _scale = scale;
        [self setNeedsDisplay];
    }
}

- (void)drawCircleAtPoint:(CGPoint)point withRadius:(CGFloat)radius inContext:(CGContextRef) context{

    UIGraphicsPushContext(context);
    CGContextBeginPath(context);
    CGContextAddArc(context, point.x, point.y, radius, 0, 2* M_PI, YES);
    CGContextStrokePath(context);
    UIGraphicsPopContext();
}

- (void)pinch:(UIPinchGestureRecognizer*)recognizer{

    if((recognizer.state == UIGestureRecognizerStateChanged) ||
       (recognizer.state == UIGestureRecognizerStateEnded)){

        self.scale *= recognizer.scale;
        recognizer.scale = 1;
    }

}



- (void)drawRect:(CGRect)rect
{
    CGContextRef context = UIGraphicsGetCurrentContext();
    CGPoint midPoint;
    midPoint.x= self.bounds.origin.x + self.bounds.size.width/2;
    midPoint.y= self.bounds.origin.y + self.bounds.size.height/2;

    CGFloat size = self.bounds.size.width / 2;
    if(self.bounds.size.height < self.bounds.size.width) size = self.bounds.size.height / 2;
    size *= self.scale;

    CGContextSetLineWidth(context, 6.0);
    [[UIColor blueColor] setStroke];

    [self drawCircleAtPoint:midPoint withRadius:size inContext:context];

#define EYE_RADIUS 0.1
#define EYE_H 0.35
#define EYE_V 0.35

    CGPoint eyePoint;
    eyePoint.x = midPoint.x - size * EYE_H;
    eyePoint.y = midPoint.y - size * EYE_V;

    [self drawCircleAtPoint:eyePoint withRadius:size* EYE_RADIUS inContext:context]; //LEFT EYE

    eyePoint.x = midPoint.x + size * EYE_H;
    [self drawCircleAtPoint:eyePoint withRadius:size* EYE_RADIUS inContext:context]; //LEFT EYE

#define MOUSE_H 0.45
#define MOUSE_V 0.40
#define MOUSE_SMILE 0.20
    CGPoint mouseStartPoint;
    mouseStartPoint.x = midPoint.x - size * MOUSE_H;
    mouseStartPoint.y = midPoint.y + size * MOUSE_V;

    CGPoint mouseEndPoint = mouseStartPoint;
    mouseEndPoint.x = midPoint.x + size * MOUSE_H;

    CGPoint mouseControlPoint1 = mouseStartPoint;
    CGPoint mouseControlPoint2 = mouseEndPoint;
    mouseControlPoint1.x += MOUSE_H*size*2/3;
    mouseControlPoint2.x -= MOUSE_H*size*2/3;

    CGFloat smile = [self.dataSource smileForFaceView:self];
    
    if(smile < -1) smile = -1;
    if(smile > 1) smile = 1;
    
    
    CGFloat smileOffset = MOUSE_SMILE * size * smile;
    mouseControlPoint1.y += smileOffset;
    mouseControlPoint2.y += smileOffset;

    CGContextBeginPath(context);
    CGContextMoveToPoint(context, mouseStartPoint.x, mouseStartPoint.y);
    CGContextAddCurveToPoint(context, mouseControlPoint1.x, mouseControlPoint1.y, mouseControlPoint2.x, mouseControlPoint2.y, mouseEndPoint.x, mouseEndPoint.y);
    CGContextStrokePath(context);
}

@end
