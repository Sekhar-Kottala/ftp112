export class Gst {

    constructor(private _stategst:number, private _centralgst:number, private _totalgst:number) {
    }
    set stategst(stategst:number){
    this._stategst = stategst;
    }
    
    get stategst():number{
        return this._stategst;
    }

    set centralgst(centralgst:number){
    this._centralgst = centralgst;
    }
        
    get centralgst():number{
    return this._centralgst;
    }

    set totalgst(totalgst:number){
        this._totalgst = totalgst;
    }
            
    get totalgst():number{
    return this._totalgst;
    }
    
}